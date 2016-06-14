package edu.olivet.se530;

import com.google.inject.*;
import edu.olivet.se530.model.*;
import org.jsoup.nodes.*;

import java.io.*;
import java.util.*;

@Singleton
public class SellerHunter {
	@Inject private HtmlCrawler htmlFetcher;
	@Inject private HtmlParser htmlParser;
	
	/**
	 * 根据给定的isbn和condition，返回亚马逊网站上面的Offer列表
	 * @param isbn		产品的ISBN编号，参见:{@link Product#getIsbn()}
	 * @param condition	产品的Condition
	 */
	public Offer huntOffer(String isbn, String condition) throws IOException {
		Document doc = htmlFetcher.getDocument(isbn, condition);
		List<Offer> offers = htmlParser.parseOffer(doc);
		
		for (Iterator<Offer> iterator = offers.iterator(); iterator.hasNext();) {
			Offer offer = iterator.next();
			if (!this.evaluate(offer)) {
				iterator.remove();
			}
		}
		
		Collections.sort(offers);
		return offers.get(0);
	}

	/**
	 * 对一个Offer按照价格、运费、Rating等等标准进行审查
	 *
	 */

    private boolean evaluate(Offer offer) {
			if(offer.getSeller().getName().equals("AP") && offer.getPrice() >= 35){
				offer.setShippingPrice(0);
			}
			return offer.getSeller().getRating() >= 95 && offer.getSeller().getRatingCount() >= 100 && offer.getSeller().getShippingCountry() != "United Kingdom";
	}

	public void setHtmlFetcher(HtmlCrawler htmlFetcher) {
		this.htmlFetcher = htmlFetcher;
	}

	public void setHtmlParser(HtmlParser htmlParser) {
		this.htmlParser = htmlParser;
	}
}
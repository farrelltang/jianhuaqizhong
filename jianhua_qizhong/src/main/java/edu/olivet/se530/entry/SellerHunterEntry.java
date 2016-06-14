package edu.olivet.se530.entry;

import com.google.inject.*;
import edu.olivet.se530.*;
import edu.olivet.se530.model.*;
import edu.olivet.se530.modules.*;

import java.io.*;

/**
 * Seller猎手
 * @author <a href="mailto:nathanaelibport@gmail.com">Nathanael Yang</a> Jan 8, 2015 2:11:20 PM
 */
class SellerHunterEntry {

	public static void main(String[] args) throws IOException {
		SellerHunter hunter = new SellerHunter();
		Guice.createInjector(new CrawlerModule()).injectMembers(hunter);
		Offer offer = hunter.huntOffer("031043601X", "New");
		System.out.println(offer);
	}
}

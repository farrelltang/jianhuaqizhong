package edu.olivet.se530;

import com.google.inject.*;
import edu.olivet.se530.dummy.*;
import edu.olivet.se530.model.*;
import org.jsoup.nodes.*;
import org.jukito.*;
import org.junit.*;
import org.junit.runner.*;

import java.io.*;
import java.util.*;

/**
 * Created by Frank on 5/20/2016.
 */
@RunWith(JukitoRunner.class)
public class DummyTest {
    @Inject
    private HtmlParser htmlParser;
    @Test
    public void dummyTest1() throws IOException {
        DummyHtmlCrawler dummyHtmlCrawler = new DummyHtmlCrawler();
        Document aNew = dummyHtmlCrawler.getDocument("0135157862", "NEW");
        List<Offer> offers = htmlParser.parseOffer(aNew);
        Assert.assertEquals("AP",offers.get(0).getSeller().getName());
    }
    @Test
    public void dummyTest2()throws IOException {
        DummyHtmlCrawler dummyHtmlCrawler = new DummyHtmlCrawler();
        Document aNew = dummyHtmlCrawler.getDocument("1416532277", "NEW");
        List<Offer> offers = htmlParser.parseOffer(aNew);
        Assert.assertEquals("BRILANTI BOOKS",offers.get(0).getSeller().getName());
    }
    @Test
    public void dummyTest3()throws IOException {
        DummyHtmlCrawler dummyHtmlCrawler = new DummyHtmlCrawler();
        Document aNew = dummyHtmlCrawler.getDocument("0907871496", "NEW");
        List<Offer> offers = htmlParser.parseOffer(aNew);
        Assert.assertEquals("pbshop",offers.get(0).getSeller().getName());
    }
}

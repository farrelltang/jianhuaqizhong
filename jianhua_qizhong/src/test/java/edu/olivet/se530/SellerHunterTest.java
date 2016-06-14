package edu.olivet.se530;


import java.io.IOException;

import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

import edu.olivet.se530.dummy.DummyModule;
import edu.olivet.se530.model.Offer;

@RunWith(JukitoRunner.class)
@UseModules(value = DummyModule.class)
public class SellerHunterTest {
	@Inject private SellerHunter hunter;

    @Test public void test_get_offer_list() throws IOException {
        String condition = "New";
        String isbn = "031043601X";
        Offer offer = hunter.huntOffer(isbn, condition);
		Assert.assertEquals("AP", offer.getSeller().getName());
	}
}

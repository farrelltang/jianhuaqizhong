package edu.olivet.se530.modules;

import com.google.inject.*;
import com.google.inject.matcher.*;
import edu.olivet.se530.*;
import edu.olivet.se530.annotations.*;
import edu.olivet.se530.aop.*;

public class CrawlerModule extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(HtmlCrawler.class).to(HtmlCrawlerImpl.class);
		
		SaveHtmlInterceptor interceptor = new SaveHtmlInterceptor();
		this.requestInjection(interceptor);
		this.bindInterceptor(Matchers.any(), Matchers.annotatedWith(SaveHtml.class), interceptor);
	}

}

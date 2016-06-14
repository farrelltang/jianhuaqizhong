package edu.olivet.se530.dummy;

import edu.olivet.se530.*;
import org.jsoup.*;
import org.jsoup.nodes.*;

import java.io.*;

public class DummyHtmlCrawler implements HtmlCrawler {

    @Override
    public Document getDocument(String isbn, String condition) throws IOException {
        String fileUrl = String.format("./Assignment/%s_%s_1.html",isbn,condition.toLowerCase());
        String htmlString = getStringFromFile(fileUrl);
        Document parse = Jsoup.parse(htmlString);
        return parse;
    }

    public String getStringFromFile(String fileUrl) throws IOException {
        File file = new File(fileUrl);
        BufferedReader bf = null;
        bf = new BufferedReader(new FileReader(file));
        String content = "";
        StringBuilder sb = new StringBuilder();
        while (content != null) {
            content = bf.readLine();
            if (content == null) {
                break;
            }
            sb.append(content.trim());
        }
        bf.close();
        return sb.toString();
    }
}

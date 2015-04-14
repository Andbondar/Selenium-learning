package InputProcessing;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bondar on 4/14/2015.
 */
public class XMLParser {
    public static List<String> getXMLInfoByXPath(String inputFile, String strXPath){
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setIgnoringElementContentWhitespace(true);
        //Here we will store mapped data from required tags
        List<String> arrStrings = new ArrayList<String>();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(inputFile);
            Document doc = builder.parse(file);
            XPath xPath =  XPathFactory.newInstance().newXPath();
            //list of elements with input tag is created
            NodeList nodeList = (NodeList) xPath.compile(strXPath).evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                //add element to arrayList of Names
                String addedValue = nodeList.item(i).getFirstChild().getNodeValue();
                arrStrings.add(addedValue);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrStrings;
    }

    public static List getInfoByTag(String inputFile, String tag){
        String xPath = "//" + tag;
        System.out.println(getXMLInfoByXPath(inputFile, xPath));
        return getXMLInfoByXPath(inputFile, xPath);
    }
}

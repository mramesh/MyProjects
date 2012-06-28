package com.anmedia.dailymail.kindlefire.parser;

import java.io.IOException;
import java.io.InputStream;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;

public class DMXMLParser {

    public void XMLParser(Context context) {

        try {
            InputStream xmlStream = context.getResources().getAssets().open("sample.xml");
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();
            System.out.println("************************************* " + xmlStream.available());
            // xpp.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            xpp.setInput(xmlStream, null);
            // xpp.nextTag();
            // readRow(xpp);
            int eventType = xpp.getEventType();
            int row = 1;
            int column = 1;
            int asset = 1;
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_DOCUMENT) {
                } else if (eventType == XmlPullParser.END_DOCUMENT) {
                } else if (eventType == XmlPullParser.START_TAG) {
                    if (xpp.getName().equalsIgnoreCase("row")) {
                        System.out.println("=========================================");
                        System.out.println("Row " + row);
                    }
                    if (xpp.getName().equalsIgnoreCase("column")) {
                        System.out.println("Column " + (column++));
                        System.out.println("Attribute Name " + xpp.getAttributeName(0) + " %%%% " + "Attribute Value "
                                + xpp.getAttributeValue(0));
                    }
                    if (xpp.getName().equalsIgnoreCase("asset")) {
                        System.out.println("Asset " + (asset++));
                        System.out.println("Attribute Name " + xpp.getAttributeName(0) + " %%%% " + "Attribute Value "
                                + xpp.getAttributeValue(0));
                    }
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (xpp.getName().equalsIgnoreCase("row")) {
                        // System.out.println("************* Row Ends*************");
                        row++;
                        column = 0;
                        System.out.println("=========================================");
                    }
                    if (xpp.getName().equalsIgnoreCase("column")) {
                        asset = 0;
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    // System.out.println("Text " + xpp.getText());
                }
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}

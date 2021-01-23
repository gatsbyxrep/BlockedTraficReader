package com.company;

import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        String cvsUrl = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210118T051130-structure-20200120T130522.csv";
        String xmlUrl = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210118T051130-structure-20200120T130522.xml";
        IParseStrategy parseStrategy = new XMLParser();
        ArrayList<BlockedTrafficInfo> infos = Reader.readFromUrl(xmlUrl, parseStrategy);
        for(BlockedTrafficInfo info : infos)
            System.out.println(info.toString());

    }
}

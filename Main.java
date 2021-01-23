package com.company;

import java.util.ArrayList;
import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) {
        String url = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210118T051130-structure-20200120T130522.csv";
        ArrayList<BlockedTrafficInfo> blockedTrafficInfoArrayList = Reader.readFromUrl(url);
        System.out.println(blockedTrafficInfoArrayList.get(0));
    }
}

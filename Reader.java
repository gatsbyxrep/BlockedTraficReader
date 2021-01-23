package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;


public class Reader {
    // Generate ArrayList of BlockedTraficInfo from remote file
    private static String readAllLinesFromUrl(String fileUrl)  {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            URL url = new URL(fileUrl);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String inputLine;
            in.readLine();
            while ((inputLine = in.readLine()) != null)
                stringBuilder.append(inputLine);
            in.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
    public static ArrayList<BlockedTrafficInfo> readFromUrl(String fileUrl, IParseStrategy strategy) {
        ArrayList<BlockedTrafficInfo> infos = null;
        try {
            infos = strategy.parse(readAllLinesFromUrl(fileUrl));
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return infos;
    }
    // TODO: read from locale file

}

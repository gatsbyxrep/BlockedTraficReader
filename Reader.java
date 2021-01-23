package com.company;

import java.text.ParseException;
import java.util.ArrayList;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;


public class Reader {
    // Generate ArrayList of BlockedTraficInfo from remote file
    public static ArrayList<BlockedTrafficInfo> readFromUrl(String fileUrl) {
        ArrayList<BlockedTrafficInfo> trafficInfos = new ArrayList<>();
        try {
            URL url = new URL(fileUrl);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String inputLine;
            in.readLine();
            while ((inputLine = in.readLine()) != null)
                trafficInfos.add(BlockedTrafficInfo.parse(inputLine));
            in.close();
        }
        catch(IOException | ParseException e) {
            e.printStackTrace();
        }
        return trafficInfos;
    }
    // TODO: read from locale file

}

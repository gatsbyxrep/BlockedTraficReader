package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CSVParser implements IParseStrategy {
    @Override
    public ArrayList<BlockedTrafficInfo> parse(String fileText) throws ParseException {
        ArrayList<BlockedTrafficInfo> infos = new ArrayList<>();
        String[] lines = fileText.split("\n");
        for(String line : lines) {
            String[] info = line.split(",");
            infos.add(new BlockedTrafficInfo(Integer.parseInt(info[0]),  info[1], info[2], info[6], info[7],
                    new SimpleDateFormat("yyyyMMdd").parse(info[10]), new SimpleDateFormat("yyyyMMdd").parse(info[11])));
        }
        return infos;
    }
}

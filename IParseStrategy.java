package com.company;

import java.text.ParseException;
import java.util.ArrayList;

public interface IParseStrategy {
    ArrayList<BlockedTrafficInfo> parse(String fileText) throws ParseException;
}

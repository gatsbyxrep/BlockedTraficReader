package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedTrafficInfo {
    private int code;
    private String orderNumber;
    private String customer;
    private String district;
    private String address;
    private Date startDate;
    private Date endDate;

    public BlockedTrafficInfo(int code, String orderNumber, String customer, String district, String address, Date startDate, Date endDate) {
        this.setCode(code);
        this.setOrderNumber(orderNumber);
        this.setCustomer(customer);
        this.setDistrict(district);
        this.setAddress(address);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static BlockedTrafficInfo parse(String line) throws ParseException {
        String[] info = line.split(",");
        return new BlockedTrafficInfo(Integer.parseInt(info[0]),  info[1], info[2], info[6], info[7],
                new SimpleDateFormat("yyyyMMdd").parse(info[10]), new SimpleDateFormat("yyyyMMdd").parse(info[11]));
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Code:" + this.code)
                .append(", Order number:" + this.getOrderNumber())
                .append(", Customer:" + this.customer)
                .append(", District:" + this.district)
                .append(", Address:" + this.address)
                .append(", Start date:" + this.startDate.toString())
                .append(", End date:" + this.endDate.toString());
        return stringBuilder.toString();

    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

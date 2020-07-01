package com.tian.project;

public enum EnumTest {
    RED("红色"), GREEN("绿色"), BLUE("蓝色");

    private String color;

    EnumTest(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public static void fun() {
        for (EnumTest c : EnumTest.values()) {
            String color = c.getColor();
            System.out.println(color);
        }
    }


    public static void main(String[] args) {
        fun();
    }
}

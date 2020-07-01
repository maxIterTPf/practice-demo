package com.tian.project;

public class CompareString {
    public static void main(String[] args) {
        String str = "191830FE49B2";
        System.out.println(str.matches("^[a-fA-F0-9]{12}$"));
    }
}

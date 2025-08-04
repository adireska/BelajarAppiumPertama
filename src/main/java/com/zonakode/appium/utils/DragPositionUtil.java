package com.zonakode.appium.utils;

public class DragPositionUtil {
    private int customX = 0;
    private int customY = 0;

    public DragPositionUtil(int x, int y) {
        this.customX = x;
        this.customY = y;
    }

    public int getCustomX() {
        return customX;
    }

    public void setCustomX(int customX) {
        this.customX = customX;
    }

    public int getCustomY() {
        return customY;
    }

    public void setCustomY(int customY) {
        this.customY = customY;
    }
}

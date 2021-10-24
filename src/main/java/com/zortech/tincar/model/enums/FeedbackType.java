package com.zortech.tincar.model.enums;

public enum FeedbackType {

    LIKE, DISLIKE;

    public static FeedbackType from(String text) {
        for (FeedbackType b : FeedbackType.values()) {
            if (b.name().equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }

}

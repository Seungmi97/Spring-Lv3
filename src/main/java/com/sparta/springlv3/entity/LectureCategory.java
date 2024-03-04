package com.sparta.springlv3.entity;

public enum LectureCategory {
    SPRING(Category.SPRING),  // 스프링 카테고리
    NODE(Category.NODE),  // 노드 카테고리
    REACT(Category.REACT);  // 리액트 카테고리

    private final String category;

    LectureCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public static class Category {
        public static final String SPRING = "CAT_SPRING";
        public static final String REACT = "CAT_REACT";
        public static final String NODE = "CAT_NODE";
    }
}

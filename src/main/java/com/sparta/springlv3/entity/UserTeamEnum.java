package com.sparta.springlv3.entity;

public enum UserTeamEnum {
        CURRICULUM(Authority.CURRICULUM),  // 커리큘럼 부서
        MARKETING(Authority.MARKETING),  // 마케팅 부서
        DEVELOPMENT(Authority.DEVELOPMENT);  // 개발 부서

        private final String authority;

        UserTeamEnum(String authority) {
            this.authority = authority;
        }

        public String getAuthority() {
            return this.authority;
        }

        public static class Authority {
            public static final String CURRICULUM = "ROLE_CURRICULUM";
            public static final String MARKETING = "ROLE_MARKETING";
            public static final String DEVELOPMENT = "ROLE_DEVELOPMENT";
        }
}

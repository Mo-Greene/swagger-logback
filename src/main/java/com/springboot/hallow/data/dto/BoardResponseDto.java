package com.springboot.hallow.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BoardResponseDto {

    private Long id;
    private String title;
    private String contents;

    public static BoardResponseDtoBuilder builder() {
        return new BoardResponseDtoBuilder();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    public static class BoardResponseDtoBuilder {
        private Long id;
        private String title;
        private String contents;

        @Override
        public String toString() {
            return "BoardResponseDtoBuilder{" +
                    "id=" + id +
                    ", title='" + title + '\'' +
                    ", contents='" + contents + '\'' +
                    '}';
        }
    }

}

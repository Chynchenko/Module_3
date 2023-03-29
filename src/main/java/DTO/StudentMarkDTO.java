package DTO;

import lombok .*;

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor

    public class StudentMarkDTO {
        private String id;
        private String firstName;
        private String surname;
        private double value;
    }



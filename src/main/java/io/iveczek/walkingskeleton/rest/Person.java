package io.iveczek.walkingskeleton.rest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Person {
    private String firstName;
    private String lastName;
}

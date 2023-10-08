package by.edu.bookservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {

    @JsonProperty("available")
    AVAILABLE,

    @JsonProperty("unavailable")
    UNAVAILABLE
}

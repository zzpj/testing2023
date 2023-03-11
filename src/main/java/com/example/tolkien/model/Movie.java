package com.example.tolkien.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Duration;
import java.time.Year;

@Data
@AllArgsConstructor
public class Movie {
    private String title;
    private Year releaseYear;
    private Duration duration;
}

package ru.zerat.pet_project.MeteoBase.util;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MeteodataErrorResponse {

    private String message;
    private long timestamp;

}

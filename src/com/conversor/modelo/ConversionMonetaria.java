package com.conversor.modelo;

public record ConversionMonetaria(String result,
                                  long time_next_update_unix,
                                  String base_code,
                                  String target_code,
                                  String conversion_rate,
                                  String conversion_result) {
}

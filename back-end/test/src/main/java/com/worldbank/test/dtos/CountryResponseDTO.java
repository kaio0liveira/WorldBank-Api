package com.worldbank.test.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CountryResponseDTO {

    private CountryDTO country;
    private String countryIso3Code;
    private String date;
    private String decimal;
    private IndicatorDTO indicator;
    private String obsStatus;
    private String unit;
    private String value;

    public CountryDTO getCountry() {
        return country;
    }

    public String getCountryIso3Code() {
        return countryIso3Code;
    }

    public String getDate() {
        return date;
    }

    public String getDecimal() {
        return decimal;
    }

    public IndicatorDTO getIndicator() {
        return indicator;
    }

    public String getObsStatus() {
        return obsStatus;
    }

    public String getUnit() {
        return unit;
    }

    public String getValue() {
        return value;
    }

    public void setCountry(CountryDTO country) {
        this.country = country;
    }

    @JsonProperty("countryiso3code")
    public void setCountryIso3Code(String countryIso3Code) {
        this.countryIso3Code = countryIso3Code;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDecimal(String decimal) {
        this.decimal = decimal;
    }

    public void setIndicator(IndicatorDTO indicator) {
        this.indicator = indicator;
    }

    @JsonProperty("obs_status")
    public void setObsStatus(String obsStatus) {
        this.obsStatus = obsStatus;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setValue(String value) {
        this.value = value;
    }

}

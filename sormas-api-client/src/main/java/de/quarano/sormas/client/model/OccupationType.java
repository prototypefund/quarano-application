/*
 * SORMAS REST API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.44.0-SNAPSHOT
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package de.quarano.sormas.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Gets or Sets OccupationType
 */
public enum OccupationType {
  FARMER("FARMER"),
  BUTCHER("BUTCHER"),
  HUNTER_MEAT_TRADER("HUNTER_MEAT_TRADER"),
  MINER("MINER"),
  RELIGIOUS_LEADER("RELIGIOUS_LEADER"),
  HOUSEWIFE("HOUSEWIFE"),
  PUPIL_STUDENT("PUPIL_STUDENT"),
  CHILD("CHILD"),
  BUSINESSMAN_WOMAN("BUSINESSMAN_WOMAN"),
  TRANSPORTER("TRANSPORTER"),
  HEALTHCARE_WORKER("HEALTHCARE_WORKER"),
  TRADITIONAL_SPIRITUAL_HEALER("TRADITIONAL_SPIRITUAL_HEALER"),
  WORKING_WITH_ANIMALS("WORKING_WITH_ANIMALS"),
  LABORATORY_STAFF("LABORATORY_STAFF"),
  OTHER("OTHER");

  private String value;

  OccupationType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static OccupationType fromValue(String text) {
    for (OccupationType b : OccupationType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }
}

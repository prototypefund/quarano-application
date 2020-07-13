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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.quarano.sormas.client.model.ClassificationCriteriaDto;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * ClassificationPersonAgeBetweenYearsCriteriaDto
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2020-07-09T17:56:16.099120+02:00[Europe/Berlin]")
public class ClassificationPersonAgeBetweenYearsCriteriaDto extends ClassificationCriteriaDto {
  @JsonProperty("lowerThreshold")
  private Integer lowerThreshold = null;

  @JsonProperty("upperThreshold")
  private Integer upperThreshold = null;

  public ClassificationPersonAgeBetweenYearsCriteriaDto lowerThreshold(Integer lowerThreshold) {
    this.lowerThreshold = lowerThreshold;
    return this;
  }

   /**
   * Get lowerThreshold
   * @return lowerThreshold
  **/
  @Schema(description = "")
  public Integer getLowerThreshold() {
    return lowerThreshold;
  }

  public void setLowerThreshold(Integer lowerThreshold) {
    this.lowerThreshold = lowerThreshold;
  }

  public ClassificationPersonAgeBetweenYearsCriteriaDto upperThreshold(Integer upperThreshold) {
    this.upperThreshold = upperThreshold;
    return this;
  }

   /**
   * Get upperThreshold
   * @return upperThreshold
  **/
  @Schema(description = "")
  public Integer getUpperThreshold() {
    return upperThreshold;
  }

  public void setUpperThreshold(Integer upperThreshold) {
    this.upperThreshold = upperThreshold;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClassificationPersonAgeBetweenYearsCriteriaDto classificationPersonAgeBetweenYearsCriteriaDto = (ClassificationPersonAgeBetweenYearsCriteriaDto) o;
    return Objects.equals(this.lowerThreshold, classificationPersonAgeBetweenYearsCriteriaDto.lowerThreshold) &&
        Objects.equals(this.upperThreshold, classificationPersonAgeBetweenYearsCriteriaDto.upperThreshold) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lowerThreshold, upperThreshold, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ClassificationPersonAgeBetweenYearsCriteriaDto {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    lowerThreshold: ").append(toIndentedString(lowerThreshold)).append("\n");
    sb.append("    upperThreshold: ").append(toIndentedString(upperThreshold)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

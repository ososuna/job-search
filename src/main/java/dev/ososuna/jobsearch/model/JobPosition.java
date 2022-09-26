package dev.ososuna.jobsearch.model;

import com.google.gson.annotations.SerializedName;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class JobPosition {
  
  private String id;
  
  private String type;
  
  private String url;
  
  @SerializedName("created_at")
  private String createdAt;

  private String company;

  @SerializedName("company_url")
  private String companyUrl;

  private String title;

  private String location;

  private String description;

  @SerializedName("company_logo")
  private String companyLogo;

}

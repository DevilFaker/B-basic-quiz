package com.gtb.quiz.answear.model;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gtb.quiz.answear.model.Education;
import lombok.Data;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

@Data
public class CreateEducationRequest {

    private  long id;

    private String description;

    private String title;

    private long year;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CreateEducationRequest(@JsonProperty("title") String title,
                                  @JsonProperty("description") String description,
                                  @JsonProperty("year") long year,
                                  @JsonProperty("userId") long id
    ) {
        this.title = title;
        this.description = description;
        this.year=year;
        this.id=id;
    }

    public Education toEducation() {
        Education education = new Education();
        education.setDescription(this.description);
        education.setTitle(this.title);
        education.setYear(this.year);
        education.setUserId(this.id);
        return education;
    }
}


package ex.vvs.et.dto.Request;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class DateDto {

    private Date startDate;
    private Date endDate;

    public DateDto() {
    }

    public DateDto(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

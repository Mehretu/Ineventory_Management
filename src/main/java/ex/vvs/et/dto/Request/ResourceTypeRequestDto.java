package ex.vvs.et.dto.Request;

public class ResourceTypeRequestDto {
    private String name;
    private Integer Id;
    public ResourceTypeRequestDto() {

    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public ResourceTypeRequestDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package clases;

import java.util.List;

/**
 *
 * @author Mario Cares
 */
public class DataJSON {
    private String title;
    private Long id;
    private Boolean children;
    private List<DataJSON> groups;

    public String getTitle() { return title; }
    public Long getId() { return id; }
    public Boolean getChildren() { return children; }
    public List<DataJSON> getGroups() { return groups; }

    public void setTitle(String title) { this.title = title; }
    public void setId(Long id) { this.id = id; }
    public void setChildren(Boolean children) { this.children = children; }
    public void setGroups(List<DataJSON> groups) { this.groups = groups; }

    @Override
    public String toString() {
        return String.format("title:%s,id:%d,children:%s,groups:%s", title, id, children, groups);
    }
}
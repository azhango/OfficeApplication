package pers.hua.oa.entity;

public class Node {
    /**
     * 节点编号
     */
    private Long nodeId;
    /**
     * 节点类型：1-模块2-功能
     */
    private int nodeType;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 功能地址
     */
    private String url;
    /**
     * 节点编码，用于排序
     */
    private int nodeCode;
    /**
     * 上级节点编号
     */
    private Long parentId;

    public Long getNodeId() {
        return nodeId;
    }

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public int getNodeType() {
        return nodeType;
    }

    public void setNodeType(int nodeType) {
        this.nodeType = nodeType;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(int nodeCode) {
        this.nodeCode = nodeCode;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}

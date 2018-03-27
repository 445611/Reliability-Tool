package fi.muni.cz.reliability.tool.core;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author Radoslav Micko <445611@muni.cz>
 */
public class OutputData implements Serializable {
    
    private String url;
    private String userName;
    private String repositoryName;
    private Date createdAt;
    private int totalNumberOfFaults;
    
    //TODO
    //Some kind of calculated data from model

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getTotalNumberOfFaults() {
        return totalNumberOfFaults;
    }

    public void setTotalNumberOfFaults(int totalNumberOfFaults) {
        this.totalNumberOfFaults = totalNumberOfFaults;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.userName, this.repositoryName, this.createdAt);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof OutputData) {
            return false;
        }
        final OutputData other = (OutputData) obj;
        if (!Objects.equals(this.userName, other.userName)) {
            return false;
        }
        if (!Objects.equals(this.repositoryName, other.repositoryName)) {
            return false;
        }
        if (!Objects.equals(this.createdAt, other.createdAt)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "OutputData for repository{" + "userName=" + userName + ", repositoryName=" + repositoryName + ", createdAt=" + createdAt + ", totalNumberOfFaults=" + totalNumberOfFaults + '}';
    }
    
    
    
}

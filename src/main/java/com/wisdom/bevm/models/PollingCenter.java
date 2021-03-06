package com.wisdom.bevm.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class PollingCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pollingCenterId;

    private String address;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(
            name = "supervisor_roll_no",
            insertable = false,
            updatable = false
    )
    private Supervisor supervisor;
    private Long supervisor_roll_no;

    @OneToMany(mappedBy = "pollingCenter")
    private List<BEVM> bevms;

    @OneToMany(mappedBy = "pollingCenter")
    private List<RegisteredVoter> registeredVoters;

    public PollingCenter(Long pollingCenterId, String address, Supervisor supervisor, Long supervisor_roll_no, List<BEVM> bevms, List<RegisteredVoter> registeredVoters) {
        this.pollingCenterId = pollingCenterId;
        this.address = address;
        this.supervisor = supervisor;
        this.supervisor_roll_no = supervisor_roll_no;
        this.bevms = bevms;
        this.registeredVoters = registeredVoters;
    }

    public PollingCenter() {
    }

    public Long getPollingCenterId() {
        return pollingCenterId;
    }

    public void setPollingCenterId(Long pollingCenterId) {
        this.pollingCenterId = pollingCenterId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public Long getSupervisor_roll_no() {
        return supervisor_roll_no;
    }

    public void setSupervisor_roll_no(Long supervisor_roll_no) {
        this.supervisor_roll_no = supervisor_roll_no;
    }

    public List<BEVM> getBevms() {
        return bevms;
    }

    public void setBevms(List<BEVM> bevms) {
        this.bevms = bevms;
    }

    public List<RegisteredVoter> getRegisteredVoters() {
        return registeredVoters;
    }

    public void setRegisteredVoters(List<RegisteredVoter> registeredVoters) {
        this.registeredVoters = registeredVoters;
    }

    @Override
    public String toString() {
        return "PollingCenter{" +
                "pollingCenterId=" + pollingCenterId +
                ", address='" + address + '\'' +
                ", supervisor=" + supervisor +
                ", supervisor_roll_no=" + supervisor_roll_no +
                ", bevms=" + bevms +
                ", registeredVoters=" + registeredVoters +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PollingCenter that = (PollingCenter) o;
        return Objects.equals(pollingCenterId, that.pollingCenterId) && Objects.equals(address, that.address) && Objects.equals(supervisor, that.supervisor) && Objects.equals(supervisor_roll_no, that.supervisor_roll_no) && Objects.equals(bevms, that.bevms) && Objects.equals(registeredVoters, that.registeredVoters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pollingCenterId, address, supervisor, supervisor_roll_no, bevms, registeredVoters);
    }
}

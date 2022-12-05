package com.eteration.simplebanking.business.response;

import com.eteration.simplebanking.controller.TransactionStatus;
import jdk.jfr.DataAmount;


public class CreditResponse {


    //approval code
    private String approvalCode;
    private TransactionStatus status;

    public CreditResponse(String approvalCode, TransactionStatus status) {
        this.approvalCode = approvalCode;
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }
}

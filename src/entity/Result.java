package entity;


public class Result {

  private long studentNo;
  private long subjectNo;
  private java.sql.Timestamp examDate;
  private long studentResult;


  public long getStudentNo() {
    return studentNo;
  }

  public void setStudentNo(long studentNo) {
    this.studentNo = studentNo;
  }


  public long getSubjectNo() {
    return subjectNo;
  }

  public void setSubjectNo(long subjectNo) {
    this.subjectNo = subjectNo;
  }


  public java.sql.Timestamp getExamDate() {
    return examDate;
  }

  public void setExamDate(java.sql.Timestamp examDate) {
    this.examDate = examDate;
  }


  public long getStudentResult() {
    return studentResult;
  }

  public void setStudentResult(long studentResult) {
    this.studentResult = studentResult;
  }

}

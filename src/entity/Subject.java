package entity;


public class Subject {

  private long subjectNo;
  private String subjectName;
  private long classHour;
  private long gradeId;


  public long getSubjectNo() {
    return subjectNo;
  }

  public void setSubjectNo(long subjectNo) {
    this.subjectNo = subjectNo;
  }


  public String getSubjectName() {
    return subjectName;
  }

  public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
  }


  public long getClassHour() {
    return classHour;
  }

  public void setClassHour(long classHour) {
    this.classHour = classHour;
  }


  public long getGradeId() {
    return gradeId;
  }

  public void setGradeId(long gradeId) {
    this.gradeId = gradeId;
  }

}

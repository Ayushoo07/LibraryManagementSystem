package com.example.LibraryManagementSystem.Services.Impl;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddStudentDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.GetStudentIdDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.UpdateStudentByIdDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.GetStudentResponseDto;
import com.example.LibraryManagementSystem.Entity.Card;
import com.example.LibraryManagementSystem.Entity.Student;
import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Exceptions.StudentNotFoundException;import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;import java.util.ArrayList;import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired StudentRepository studentRepository;

  @Override
  public String addStudent(AddStudentDto studentRequestDto) {

    Student student=new Student();
    student.setName(studentRequestDto.getName());
    student.setAge(studentRequestDto.getAge());
    student.setMobNo(studentRequestDto.getMobNo());
    student.setDepartment(studentRequestDto.getDepartment());
    student.setEmail(studentRequestDto.getEmail());

    Card card=new Card();
    card.setCardStatus(CardStatus.ACTIVATED);

    card.setValidTill("2024-8-20");
    card.setStudent(student);
    student.setCard(card);

    studentRepository.save(student);

    return "Student Added Successfully";
    }

    @Override
  public String deleteStudent(GetStudentIdDto getStudentIdDto)throws Exception
    {
      Student student=new Student();
      try {
          student=studentRepository.findById(getStudentIdDto.getStudentId()).get();
      }
      catch (Exception e)
      {
        throw new Exception("Student od Does Not Exist");
      }

      studentRepository.deleteById(student.getId());

      return "student deleted Successfully";
    }

  @Override
  public String updateStudentById(UpdateStudentByIdDto updateStudentByIdDto)throws Exception {

    Student student = new Student();
    try {
        student=studentRepository.findById(updateStudentByIdDto.getId()).get();
    }
    catch (Exception e){
      throw new StudentNotFoundException("Student id Does Not Exist");
    }


    if(updateStudentByIdDto.getName()!=null)
      student.setName(updateStudentByIdDto.getName());
    if(updateStudentByIdDto.getMobNo()!=null)
      student.setMobNo(updateStudentByIdDto.getMobNo());
    if(updateStudentByIdDto.getAge()!=0)
      student.setAge(updateStudentByIdDto.getAge());
    if(updateStudentByIdDto.getDepartment()!=null)
      student.setDepartment(updateStudentByIdDto.getDepartment());
    if(updateStudentByIdDto.getEmail()!=null)
      student.setEmail(updateStudentByIdDto.getEmail());

    studentRepository.save(student);

    return "Student updated Successfully";
  }

  @Override
  public GetStudentResponseDto getStudentById(GetStudentIdDto getStudentIdDto) throws Exception {
    Student student=new Student();
    GetStudentResponseDto getStudentResponseDto=new GetStudentResponseDto();

    try {
        student=studentRepository.findById(getStudentIdDto.getStudentId()).get();
    }
    catch (Exception e)
    {
      throw new StudentNotFoundException("Student does not Exist");
    }

    getStudentResponseDto.setName(student.getName());
    getStudentResponseDto.setId(student.getId());
    getStudentResponseDto.setDepartment(student.getDepartment());
    getStudentResponseDto.setAge(student.getAge());
    getStudentResponseDto.setMobNo(student.getMobNo());

    return getStudentResponseDto;
  }

  @Override
  public List<GetStudentResponseDto> getAllStudent() {
      List<GetStudentResponseDto> res=new ArrayList<>();
      List<Student> students=studentRepository.findAll();

      for (Student student: students) {
          GetStudentResponseDto getStudentResponseDto=new GetStudentResponseDto();
          getStudentResponseDto.setName(student.getName());
          getStudentResponseDto.setId(student.getId());
          getStudentResponseDto.setDepartment(student.getDepartment());
          getStudentResponseDto.setMobNo(student.getMobNo());
      getStudentResponseDto.setAge(student.getAge());
      getStudentResponseDto.setEmail(student.getEmail());

          res.add(getStudentResponseDto);
      }

      return res;


    }

}

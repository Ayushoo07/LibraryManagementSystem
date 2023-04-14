package com.example.LibraryManagementSystem.Controllers;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddStudentDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.GetStudentIdDto;import com.example.LibraryManagementSystem.DTO.RequestDto.UpdateStudentByIdDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.GetStudentResponseDto;
import com.example.LibraryManagementSystem.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController
{
  @Autowired StudentService studentService;

  @PostMapping("/add")
  public String addStudent(@RequestBody AddStudentDto studentRequestDto) {


        return studentService.addStudent(studentRequestDto);
    }

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestBody GetStudentIdDto getStudentIdDto)throws Exception
    {
      return studentService.deleteStudent(getStudentIdDto);
    }

    @PutMapping("/updateById")
  public String updateById(@RequestBody UpdateStudentByIdDto updateStudentDto)throws Exception
    {
      return studentService.updateStudentById(updateStudentDto);
    }



    @GetMapping("/getStudentById")
  public GetStudentResponseDto getStudentById(@RequestBody GetStudentIdDto getStudentIdDto)throws Exception
    {
      return studentService.getStudentById(getStudentIdDto);
    }

  @GetMapping("/getAllStudents")
  public List<GetStudentResponseDto> getAllStudent()
  {
    return studentService.getAllStudent();
  }

}

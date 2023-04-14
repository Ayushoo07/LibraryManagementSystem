package com.example.LibraryManagementSystem.Services;

import com.example.LibraryManagementSystem.DTO.RequestDto.AddStudentDto;
import com.example.LibraryManagementSystem.DTO.RequestDto.GetStudentIdDto;import com.example.LibraryManagementSystem.DTO.RequestDto.UpdateStudentByIdDto;
import com.example.LibraryManagementSystem.DTO.ResponseDto.GetStudentResponseDto;import java.util.List;

public interface StudentService
{
    public String addStudent(AddStudentDto studentRequestDto);

  public String deleteStudent(GetStudentIdDto getStudentIdDto)throws Exception;

  public String updateStudentById(UpdateStudentByIdDto updateStudentByIdDto)throws Exception;

  public GetStudentResponseDto getStudentById(GetStudentIdDto getStudentIdDto) throws Exception;
  public   List<GetStudentResponseDto> getAllStudent();
}

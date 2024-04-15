package jp.ac.ohara.score.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.ac.ohara.score.modls.StudentModel;
import jp.ac.ohara.score.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
    private StudentRepository studentRepository;
	
	// 全生徒取得メソッド
    public List<StudentModel> getAllStudents() {
        return studentRepository.findAll();
    }
	
	// 生徒追加メソッド
    public void saveStudent(StudentModel studentModel) {
        studentRepository.save(studentModel);
    }
}
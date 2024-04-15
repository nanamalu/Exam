package jp.ac.ohara.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jp.ac.ohara.score.modls.StudentModel;

public interface StudentRepository extends JpaRepository<StudentModel,Long>{

}

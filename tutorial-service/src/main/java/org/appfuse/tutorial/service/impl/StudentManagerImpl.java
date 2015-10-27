package org.appfuse.tutorial.service.impl;

import javax.jws.WebService;

import org.appfuse.service.impl.GenericManagerImpl;
import org.appfuse.tutorial.dao.StudentDao;
import org.appfuse.tutorial.model.Student;
import org.appfuse.tutorial.service.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("studentManager")
@WebService(serviceName = "StudentService", endpointInterface = "org.appfuse.tutorial.service.StudentManager")
public class StudentManagerImpl extends GenericManagerImpl<Student, Long>implements StudentManager {

	StudentDao studentDao;

	public StudentManagerImpl() {
	}

	@Autowired
	public StudentManagerImpl(StudentDao studentDao) {
		super(studentDao);
		this.studentDao = studentDao;
	}

	@Override
	public Long incrementCount(Long id) {
		Long count = 0L;
		Student student = studentDao.get(id);

		if (student != null && student.getCount() != null) {
			count = student.getCount() + 1;
			student.setCount(count);
			studentDao.save(student);
		}

		return count;
	}

}

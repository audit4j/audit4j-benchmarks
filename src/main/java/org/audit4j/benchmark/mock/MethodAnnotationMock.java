package org.audit4j.benchmark.mock;

import org.audit4j.core.annotation.Audit;
import org.audit4j.core.annotation.AuditField;
import org.audit4j.core.annotation.DeIdentify;


public class MethodAnnotationMock {

	@Audit
	public void testAnnotation_selection_all(Integer a, String b, MethodAnnotationMock c, Object d, String e) {

	}

	@Audit
	public void testAnnotation_selection_marked(@AuditField(field = "a") Integer a, @AuditField(field = "b") String b,
			@AuditField(field = "c") MethodAnnotationMock c, Object d,
			@AuditField(field = "e") String e) {
	}
	
	@Audit
	public void testAnnotation_selection_marked_deidentify(@DeIdentify @AuditField(field = "b") String b) {
	}
	
	@Audit
	public void testAnnotation_selection_marked_deidentify_from_left(@DeIdentify(fromLeft=2) @AuditField(field = "b") String b) {
	}
	
	@Audit
	public void testAnnotation_selection_marked_deidentify_from_right(@DeIdentify(fromRight=2) @AuditField(field = "b") String b) {
	}
}

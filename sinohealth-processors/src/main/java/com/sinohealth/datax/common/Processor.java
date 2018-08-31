package com.sinohealth.datax.common;

public interface Processor<I, O> {

	public O dataProcess(I i, O o, CommonData commonData);

}

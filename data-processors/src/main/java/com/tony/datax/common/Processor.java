package com.tony.datax.common;

import com.tony.datax.entity.BizData;

public interface Processor<I, O> {

	public O dataProcess(I i, O o, BizData bizData);

}

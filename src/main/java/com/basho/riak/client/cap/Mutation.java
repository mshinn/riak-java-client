/*
 * This file is provided to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.basho.riak.client.cap;

/**
 * A Mutation is some encapsulated logic that generates a new value from some previous value
 * 
 * <p>
 * Big thanks to Coda Hale from Yammer for this. Modelling your data as
 * logically monotonic makes store operations more predictable in a distributed
 * environment. Basically changing data *based on its
 * contents* and your logic. As the simplest example:
 * 
 * Rather than creating a riak object with a value of (say 25) you create a
 * Mutation that adds 1 to whatever value comes from Riak
 * </p>
 * 
 * @author russell
 * 
 */
public interface Mutation<T> {
    /**
     * Applies a mutation to the <code>original</code> value passed in
     * 
     * @param original
     *            the value to mutate.
     * @return the mutated value.
     */
    T apply(T original);
}

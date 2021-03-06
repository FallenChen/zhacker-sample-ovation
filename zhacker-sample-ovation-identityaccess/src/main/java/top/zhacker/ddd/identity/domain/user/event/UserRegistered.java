//   Copyright 2012,2013 Vaughn Vernon
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//       http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.

package top.zhacker.ddd.identity.domain.user.event;


import java.util.Date;

import lombok.Getter;
import top.zhacker.core.model.DomainEvent;
import top.zhacker.ddd.identity.domain.tenant.TenantId;
import top.zhacker.ddd.identity.domain.user.person.EmailAddress;
import top.zhacker.ddd.identity.domain.user.person.FullName;

@Getter
public class UserRegistered implements DomainEvent {

    private EmailAddress emailAddress;
    private int eventVersion;
    private FullName name;
    private Date occurredOn;
    private TenantId tenantId;
    private String username;

    public UserRegistered(
            TenantId aTenantId,
            String aUsername,
            FullName aName,
            EmailAddress anEmailAddress) {

        super();

        this.emailAddress = anEmailAddress;
        this.eventVersion = 1;
        this.name = aName;
        this.occurredOn = new Date();
        this.tenantId = aTenantId;
        this.username = aUsername;
    }

    public EmailAddress emailAddress() {
        return this.emailAddress;
    }

    @Override
    public int getEventVersion() {
        return this.eventVersion;
    }

    public FullName name() {
        return this.name;
    }

    @Override
    public Date getOccurredOn() {
        return this.occurredOn;
    }

    public TenantId tenantId() {
        return this.tenantId;
    }

    public String username() {
        return this.username;
    }
}

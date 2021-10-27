import { TestBed } from '@angular/core/testing';

import { SearchTicketService } from './search-ticket.service';

describe('SearchTicketService', () => {
  let service: SearchTicketService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SearchTicketService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

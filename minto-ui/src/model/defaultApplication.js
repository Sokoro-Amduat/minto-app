import { defaultPerson } from "./defaultPerson";
import { defaultUser } from "./defaultUser";

export const defaultApplication = {
    id: null,
    applicationNumber: "",
    applicationStatus: "",
    maritalStatus: "",
    user: { ...defaultUser },
    person: { ...defaultPerson },
    parents: [],
    spouses: [],
    children: [],
    siblings: [],
    referees: [],
    relatives: [],
    beneficiaries: [],
    submittedDate: "",
    approvedDate: "",
    rejectedDate: "",
    notes: "",
    rejectionReason: "",
    appCreatedAt: "",
    appUpdatedAt: "",
    editable: true,
    approved: false,
    submitted: false
};
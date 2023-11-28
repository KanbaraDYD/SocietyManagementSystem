import { get } from "../axios"

export function getPageVisited(params)
{
    return get("/manage/getPageVisited",params)
}